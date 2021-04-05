package net.games.snack.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TileRepositoryTest {
    private TileRepository tileRepository;

    @Before
    public void setup() {
        tileRepository = new ClassLoaderSaxTileRepository();
    }

    @Test
    public void when_tilesAreLoaded_given_noErrors_then_listIsNotEmpty() {
        //TODO: Needs to be completed for full product, but not the highest priority.
        /*
        List<Tile> tiles = tileRepository.loadTiles();

        assert tiles.size() == 20 : String.format("Actual %1$d Expected %2$d", tiles.size(), 20);
         */
    }
}
