package dk.sdu.mmmi.cbse.playersystem;


import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;

import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class PlayerControlSystemTest {
    
    GameData gameData = new GameData();
    World world = new World();

    @Test
    public void process() {
        new PlayerPlugin().start(gameData, world);
        gameData.setDisplayWidth(400);
        gameData.setDisplayHeight(400);
        gameData.setDelta(1.5f);
        
        for (Entity player : world.getEntities(Player.class)) {
            PositionPart positionPart = player.getPart(PositionPart.class);
            MovingPart movingPart = player.getPart(MovingPart.class);
            long endTime = System.currentTimeMillis() + 5 * 1000;
            while (System.currentTimeMillis() < endTime) {
                System.out.println("Running method...");
                movingPart.setUp(true);
                movingPart.process(gameData, player);
                positionPart.process(gameData, player);
                System.out.println("dx is: " + movingPart.getDx() + " dy is: " + movingPart.getDy());
                System.out.println("x is: " + positionPart.getX() + " y is: " + positionPart.getY());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            assertTrue(positionPart.getX() > 0);
        }
    }
}
