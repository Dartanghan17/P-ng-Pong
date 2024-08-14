public class BallMovement {

    //He set theese to public but i dont know where he will use it so i ll just make them private

    private Rectangle ballRectangle;// ball
    private Rectangle playerRectangle;// leftside
    private Rectangle aiRectangle; //right side
    //altı düzeltmek lazım  sanki constants a atasam daha iyi olur sanki

    private double velocityY = Constants.ballVelocityY;
    private double velocityX = Constants.ballVelocityX;

    public Text leftScoreText ;
    public Text rightScoreText;
    public static int leftScore;
    public static int rightScore;

    //public static boolean startPressed=false;




    public BallMovement(Rectangle ballRectangle, Rectangle playerRectangle,Rectangle aiRectangle,Text rightScoreText, Text leftScoreText){
        this.ballRectangle = ballRectangle;
        this.playerRectangle = playerRectangle;
        this.aiRectangle =aiRectangle;
        this.leftScoreText = leftScoreText;
        this.rightScoreText = rightScoreText;

    }

    public double calculateAngle(Rectangle paddle){
        // alttakini farklı yazdım adamdan bakalım bence adamınki hatalı
        // adamın yazdığı.:
        double relativeIntersectY = (paddle.getY() +(paddle.getHeight()/2.0))-(this.ballRectangle.getY()+(this.ballRectangle.getHeight()/2.0));
        //double relativeIntersectY = ((paddle.getY() + paddle.getHeight())/2.0)-((this.ballRectangle.getY()+this.ballRectangle.getHeight())/2.0); //Topla çubuğun kesişim noktası
        double normalIntersectY = relativeIntersectY/ (paddle.getHeight()/2.0); // oran
        double theta = normalIntersectY * Constants.maxAngle; //açı

        return Math.toRadians(theta);
    }


    public void update(double dt) {
        //Burada hızın negatif pozitifliğinden yola çıkarak topun sağa mı sola mı
        //gittiğini anlayıp ona göre kod yazıyoruz.

        if (velocityY > 0) {
            //Top aşağı giderken
            if (this.ballRectangle.getY() + this.ballRectangle.getHeight() > Constants.windowHeight) {
                this.velocityY *= -1;
            }

        } else if (velocityY < 0) {
            //Top yukarı giderken
            if (this.ballRectangle.getY() < Constants.toolbarHeight) {
                //this condition doesnot work why???
                //I hardcoded this  because when i use Constants.toolbarHeight it doesnot work
                //the thing is toolbar heigt is propably 30 pixels it works on my pc does it work on others i dont know
                //but i will learn
                this.velocityY *= -1;

            }
        }

        if (velocityX > 0) {
            //Top sağa gidiyorsa
            // Topun sağdaki çubuğa çarpması
            if (this.ballRectangle.getX() <= this.aiRectangle.getX() + this.aiRectangle.getWidth()
                    && this.ballRectangle.getX() + this.ballRectangle.getWidth() >= this.aiRectangle.getX()
                    && this.ballRectangle.getY() >= this.aiRectangle.getY()
                    && this.ballRectangle.getY() <= this.aiRectangle.getY() + this.aiRectangle.getHeight()) {


                double theta = calculateAngle(aiRectangle);
                double newVx = (Math.abs(Math.cos(theta))) * Math.sqrt(Math.pow(this.velocityX,2)+Math.pow(this.velocityY,2));
                double newVy = (-Math.sin(theta)) * Math.sqrt(Math.pow(this.velocityX,2)+Math.pow(this.velocityY,2));

                double oldSign = Math.signum(velocityX);
                this.velocityX = (newVx * (-1.0 * oldSign));
                this.velocityY = newVy;
            }
            if (this.ballRectangle.getX() > this.aiRectangle.getX() + this.aiRectangle.getWidth()) {
                rightScore = Integer.parseInt(rightScoreText.text);
                rightScore++;
                rightScoreText.text = "" + rightScore;
                // Top SIFIRLAMA
                this.ballRectangle.setX(Constants.windowWidth / 2);
                this.ballRectangle.setY(Constants.playerHeight / 2);
                this.velocityX = Constants.ballVelocityX;
                this.velocityY = Constants.ballVelocityY;

                if (rightScore >= Constants.winningScore) {
                    Main.state =5;
                    System.exit(10);
                }
                if (leftScore >= Constants.winningScore) {
                    Main.state =5;
                    System.exit(11);
                }




            }

        } else if (velocityX < 0) {
            //Top sola gidiyorsa
            //  Topun soldaki çubuğa çarpması
            if (this.ballRectangle.getX() <= this.playerRectangle.getX() + this.playerRectangle.getWidth()
                    && this.ballRectangle.getX() >= this.playerRectangle.getX()
                    && this.ballRectangle.getY() >= this.playerRectangle.getY()
                    && this.ballRectangle.getY() <= this.playerRectangle.getY() + this.playerRectangle.getHeight()) {
                double theta = calculateAngle(playerRectangle);
                double newVx = (Math.abs(Math.cos(theta))) * Math.sqrt(Math.pow(this.velocityX,2)+Math.pow(this.velocityY,2));
                double newVy = (-Math.sin(theta)) * Math.sqrt(Math.pow(this.velocityX,2)+Math.pow(this.velocityY,2));


                double oldSign = Math.signum(velocityX);
                this.velocityX = (newVx * (-1.0 * oldSign));
                this.velocityY = newVy;



                // Should i extract this from above if like i think this should be in update not other ifs
            } else if (this.ballRectangle.getX() + this.ballRectangle.getWidth() < this.playerRectangle.getX()) {
                leftScore = Integer.parseInt(leftScoreText.text);
                leftScore++;
                leftScoreText.text = "" + leftScore;
                //BALL HOMING
                this.ballRectangle.setX(Constants.windowWidth / 2);
                this.ballRectangle.setY(Constants.windowHeight / 2);
                this.velocityX = Constants.ballVelocityX;
                this.velocityY = Constants.ballVelocityY;
                //Win condition

                if (leftScore >= Constants.winningScore) {
                    Main.state =5;
                    System.exit(11);
                }
                if (rightScore >= Constants.winningScore) {
                    Main.state =5;
                    System.exit(10);
                }


            }
                /*Ayrıca aşağıdaki şekilde adım adım formüllendiriyoruz.
                //pozisyon = pozisyon + hız
                // hız = hız + hızlanma
                */
        }
        //Topun ilerlemesi
        double positionX = this.ballRectangle.getX();
        double positionY = this.ballRectangle.getY();
        positionX += (velocityX * dt);
        positionY += (velocityY * dt);
        this.ballRectangle.setX(positionX);
        this.ballRectangle.setY(positionY);
        //Win condition




    }
}
