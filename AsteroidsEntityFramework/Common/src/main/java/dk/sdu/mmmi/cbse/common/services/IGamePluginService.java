package dk.sdu.mmmi.cbse.common.services;

import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;

public interface IGamePluginService {
    /**
     * Add data on component installation. Like a player or enemy entity
     * @param gameData      Contains delta time of late update but also width and height of the screen
     * @param world         Contains all the entities and vector for them
     */
    void start(GameData gameData, World world);

    /**
     * Remove/Clean up on uninstallation.
     * @param gameData      Contains delta time of late update but also width and height of the screen
     * @param world         Contains all the entities and vector for them
     */
    void stop(GameData gameData, World world);
}
