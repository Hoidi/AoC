package Y2017;

public class Directions {

    private int north = 0;
    private int northEast = 0;
    private int southEast = 0;
    private int south = 0;
    private int southWest = 0;
    private int northWest = 0;


    public int calculateLength(){

        opposites();
        combine();

        int all = north + northEast + southEast + south + southWest + northWest;

        System.out.println(all);
        return all;
    }

    private void combine() {
        while(north > 0 && southEast > 0) {
            north--;
            southEast--;
            northEast++;
        }
        while(northEast > 0 && south > 0) {
            northEast--;
            south--;
            southEast++;
        }
        while(southEast > 0 && southWest > 0) {
            southEast--;
            southWest--;
            south++;
        }
        while(south > 0 && northWest > 0) {
            south--;
            northWest--;
            southWest++;
        }
        while(southWest > 0 && north > 0) {
            southWest--;
            north--;
            northWest++;
        }
        while(northWest > 0 && northEast > 0) {
            northWest--;
            northEast--;
            north++;
        }
    }

    private void opposites() {
        while(north >= south && south > 0) {
            north--;
            south--;
        }while (south >= north && north > 0) {
            south--;
            north--;
        }

        while(northEast >= southWest && southWest > 0) {
            northEast -= southWest;
            southWest = 0;
        } while(southWest >= northEast && northEast > 0) {
            southWest--;
            northEast--;
        }

        while(southEast >= northWest && northWest > 0) {
            southEast--;
            northWest--;
        } while(northWest >= southEast && southEast > 0) {
            northWest--;
            southEast--;
        }
    }

    public void incNorth() {
        north++;
    }

    public void incNorthEast() {
        northEast++;
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

    public void incNorthWest() {
        northWest++;
    }
}
