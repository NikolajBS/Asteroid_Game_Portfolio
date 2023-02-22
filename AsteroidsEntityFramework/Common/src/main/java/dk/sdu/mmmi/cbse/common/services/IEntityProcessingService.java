package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IEntityProcessingService {
    /**
     * Well it does some processing I guess.
     * @param gameData      Contains delta time of late update but also width and height of the screen
     * @param world         Contains all the entities and vector for them
     */
    void process(GameData gameData, World world);
}
