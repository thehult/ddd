package se.sebpa096.tobhu543.ddd.ingame.camera;

import se.sebpa096.tobhu543.ddd.ingame.Room;

public class RoomCamera extends Camera {
    private Room lockedRoom = null;

    public RoomCamera(Room room) {
        super();
        this.lockedRoom = room;
    }
}
