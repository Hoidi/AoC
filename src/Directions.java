public class Directions {

    private int north = 0;
    private int northEast = 0;
    private int east = 0;
    private int southEast = 0;
    private int south = 0;
    private int southWest = 0;
    private int west = 0;
    private int northWest = 0;


    public void calculateLength(){
        compare();

        while(north > 0 && east > 0) {
            north--;
            east--;
            northEast++;
        }
        while(east > 0 && south > 0) {
            east--;
            south--;
            southEast++;
        }
        while(south > 0 && west > 0) {
            south--;
            west--;
            southWest++;
        }
        while(west > 0 && north > 0) {
            west--;
            north--;
            northWest++;
        }
        compare();
        while(northWest > 0 && northEast > 0) {
            northWest--;
            northEast--;
            north++;
        }
        while(northEast > 0 && southEast > 0) {
            northEast--;
            southEast--;
            east++;
        }
        while(southEast > 0 && southWest > 0) {
            southEast--;
            southWest--;
            south++;
        }
        while(southWest > 0 && northWest > 0) {
            northWest--;
            southWest--;
            west++;
        }
        compare();


        System.out.println(north + northEast + east + southEast + south + southWest + west +
                northWest);
    }

    private void compare() {
        if(north >= south && south > 0) {
            north -= south;
        } else if (south >= north && north > 0) {
            south -= north;
        }

        if (east >= west && west > 0) {
            east -=west;
        } else if(west >= east && east > 0) {
            west -= east;
        }

        if(northEast >= southWest && southWest > 0) {
            northEast -= southWest;
        } else if(southWest >= northEast && northEast > 0) {
            southWest -= northEast;
        }

        if(southEast >= northWest && northWest > 0) {
            southEast -= northWest;
        } else if(northWest >= southEast && southEast > 0) {
            northWest -= southEast;
        }
    }

    public void incNorth() {
        north++;
    }

    public void incNorthEast() {
        northEast++;
    }

    public void incEast() {
        east++;
    }

    public void incSouthEast() {
        southEast++;
    }

    public void incSouth() {
        south++;
    }

    public void incSouthWest() {
        southWest++;
    }

    public void incWest() {
        west++;
    }

    public void incNorthWest() {
        northWest++;
    }
}
