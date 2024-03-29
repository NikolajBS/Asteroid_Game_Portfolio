package dk.sdu.mmmi.cbse.asteroidsystem;

import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;

import java.util.Random;

import static dk.sdu.mmmi.cbse.common.data.GameKeys.*;

public class AsteroidControlSystem implements IEntityProcessingService {
    int randomNum = new Random().nextInt(0,2);
    int counter = 0;
    @Override
    public void process(GameData gameData, World world) {

        for (Entity asteroids : world.getEntities(Asteroid.class)) {
            PositionPart positionPart = asteroids.getPart(PositionPart.class);
            MovingPart movingPart = asteroids.getPart(MovingPart.class);
            if (counter < 10 & randomNum == 1) {
                movingPart.setLeft(true);
            }
            else if(counter < 10 & randomNum == 0) {
                movingPart.setRight(true);
            }
            else if(counter > 10) {
                movingPart.setLeft(false);
                movingPart.setRight(false);
            }
            counter++;
            movingPart.setUp(true);

            movingPart.process(gameData, asteroids);
            positionPart.process(gameData, asteroids);

            updateShape(asteroids);

        }
    }
    private void updateShape(Entity entity) { //TODO change the shape of the asteroids
        float[] shapex = entity.getShapeX();
        float[] shapey = entity.getShapeY();
        PositionPart positionPart = entity.getPart(PositionPart.class);
        float x = positionPart.getX();
        float y = positionPart.getY();
        float radians = positionPart.getRadians();

        shapex[0] = (float) (x + Math.cos(radians) * 8);
        shapey[0] = (float) (y + Math.sin(radians) * 8);

        shapex[1] = (float) (x + Math.cos(radians - 8 * 3.1415f / 5) * 8);
        shapey[1] = (float) (y + Math.sin(radians - 8 * 3.1145f / 5) * 8);

        shapex[2] = (float) (x + Math.cos(radians + 3.1415f) * 5);
        shapey[2] = (float) (y + Math.sin(radians + 3.1415f) * 5);

        shapex[3] = (float) (x + Math.cos(radians + 8 * 3.1415f / 5) * 8);
        shapey[3] = (float) (y + Math.sin(radians + 8 * 3.1415f / 5) * 8);

        //shapex[4] = (float) (x + Math.cos(radians + 6 * 3.1415f / 5) * 12);
        //shapey[4] = (float) (y + Math.sin(radians + 6 * 3.1415f / 5) * 12);

        entity.setShapeX(shapex);
        entity.setShapeY(shapey);
    }
}
