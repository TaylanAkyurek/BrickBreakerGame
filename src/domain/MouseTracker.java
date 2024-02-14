package domain;

import Obstacle.Obstacle;

public class MouseTracker {

    public static void FirstClick (int mouseX,int mouseY,GameMapHandler gameMapController){
        for (Obstacle obs : gameMapController.getAllObstacles()) {

            if (mouseX >=  obs.getSpecialX() && mouseX <= obs.getSpecialX() + obs.getSize() && mouseY >= obs.getSpecialY() && mouseY <= obs.getSpecialY() + obs.getSize()) {
                obs.setChoosen(true);

            }



        }

    }
    public static void NextClick (int mouseX,int mouseY,GameMapHandler gameMapController, boolean secondClickObstacle){
        for(Obstacle obs : gameMapController.getAllObstacles()) {

            if (mouseX >=  obs.getSpecialX() && mouseX <= obs.getSpecialX() + obs.getSize() && mouseY >= obs.getSpecialY() && mouseY <= obs.getSpecialY() + obs.getSize()) {
                obs.setSecondClickObject(true);
                secondClickObstacle = true;

            }


        }

        for (Obstacle obs : gameMapController.getAllObstacles()) {


            if(obs.isChoosen() == true && !secondClickObstacle) {

                obs.setSpecialX(mouseX);
                obs.setSpecialY(mouseY);
                obs.setChoosen(false);
            }
            else if(obs.isChoosen() == true && secondClickObstacle) {

                for(Obstacle obs2 : gameMapController.getAllObstacles()) {
                    int tempX = 0;
                    int tempY = 0;
                    if(obs2.isSecondClickObject()) {
                        tempX = obs.getSpecialX();
                        tempY = obs.getSpecialY();
                        obs.setSpecialX(obs2.getSpecialX());
                        obs.setSpecialY(obs2.getSpecialY());

                        obs2.setSpecialX(tempX);
                        obs2.setSpecialY(tempY);
                        obs2.setSecondClickObject(false);
                    }

                }
                obs.setChoosen(false);


            }

        }
}
}