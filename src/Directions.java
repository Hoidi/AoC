public class Directions {

    private int north = 0;
    private int northEast = 0;
    private int southEast = 0;
    private int south = 0;
    private int southWest = 0;
    private int northWest = 0;


    public void calculateLength(){

        opposites();

        System.out.println(north + northEast + southEast + south + southWest + northWest);
    }

    private void combine() {

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
