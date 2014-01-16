package se.sebpa096.tobhu543.ddd.ingame.entities;

import se.sebpa096.tobhu543.ddd.ingame.Room;

@SuppressWarnings("JavaDoc")
public interface IEntityListener {
    public void entityChanged();
    public void entityChangedRoom(Room room);
}
