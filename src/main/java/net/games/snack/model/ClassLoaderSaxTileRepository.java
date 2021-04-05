package net.games.snack.model;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassLoaderSaxTileRepository extends DefaultHandler implements TileRepository {
    private static final Pattern HOUSE_PATTERN = Pattern.compile("house([0-9]+)]");
    private static final String ROAD_TEMPLATE = "road";
    private static final String EMPTY_TEMPLATE = "empty";
    private static final String SHOP_RED_TEMPLATE = "red";
    private static final String SHOP_YELLOW_TEMPLATE = "yellow";
    private static final String SHOP_GREEN_TEMPLATE = "green";
    private static final String TILES = "tiles";
    private static final String TILE = "tile";
    private static final String CELL = "cell";
    private List<Tile> tiles;
    private List<Cell> cells;

    @Override
    public void startDocument() throws SAXException {
        tiles = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String lName, String qName, Attributes attr) throws SAXException {
        switch(qName) {
            case TILES:
                tiles = new ArrayList<>();
                break;
            case TILE:
                if (cells == null) {
                    this.cells = new ArrayList<>();
                }
                cells.clear();
                break;
            case CELL:
                StringBuffer buffer = new StringBuffer();
                int x;
                int y;
                CellType type;
                int id;
                for (int i = 0; i < attr.getLength(); i++) {
                    switch (attr.getQName(i)) {
                        case "x":
                            x = Integer.parseInt(attr.getValue(i));
                            break;
                        case "y":
                            y = Integer.parseInt(attr.getValue(i));
                            break;
                        case "value":
                            Matcher matcher = null;
                            String value = attr.getValue(i);
                            if (ROAD_TEMPLATE.equals(value)) {
                                type = CellType.ROAD;
                            } else if (EMPTY_TEMPLATE.equals(value)) {
                                type = CellType.EMPTY;
                            } else if ( SHOP_RED_TEMPLATE.equals(value) ) {
                                type = CellType.RED;
                                value = matcher.group(1);
                            } else if ( SHOP_YELLOW_TEMPLATE.equals(value) ) {
                                type = CellType.YELLOW;
                                value = matcher.group(1);
                            } else if ( SHOP_GREEN_TEMPLATE.equals(value) ) {
                                type = CellType.GREEN;
                                value = matcher.group(1);
                            } else if ( (matcher = HOUSE_PATTERN.matcher(value)).matches() ) {
                                value = matcher.group(1);
                            }
                            break;
                    }
                }
                logDetails(buffer.toString());
                break;
            default:
                break;
        }
    }

    @Override
    public void endElement(String uri, String lName, String qName) throws SAXException {
        switch (qName) {
            case TILES:
                logDetails("stop tiles");
                break;
            case TILE:
                logDetails("stop tile");
                break;
            case CELL:
                logDetails("stop cell");
                break;
            default:
                break;
        }
    }

    private void logDetails(String message) {
        System.out.println(message);
        System.out.flush();
    }

    @Override
    public List<Tile> loadTiles() {
        if (tiles == null || tiles.size() == 0) {
            try {
                SAXParserFactory factory = SAXParserFactory.newInstance();
                SAXParser parser = factory.newSAXParser();
                parser.parse(ClassLoader.getSystemResourceAsStream("model/tiles.xml"), this);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return tiles;
    }
}
