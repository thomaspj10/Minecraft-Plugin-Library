# Minecraft-Plugin-Library
A Minecraft library which has advanced features for developers.  



# Features
* Listen to global events.
* Listen to entity specific events.
* Listen to commands.
* Save data and load data.
* Create and modify inventories.
* Execute code stored as json.

# Documentation

Setting up the PluginLibrary.
```java
class Main extends JavaPlugin {

  public static final PluginLibrary library = new PluginLibrary(this);

  @Override
  public void onEnable() {
    
  }
  
  @Override
  public void onDisable() {

  }

}
```

## Listeners
Global event listener.
```java
library.on(PlayerMoveEvent.class, e -> {
  e.getPlayer().sendMessage("You moved!");
});
```

Global command listener. (Note: This does NOT require you to specify the command in the plugin.yml).
```java
library.onCommand("hello", "Sends you a nice hello.", "/hello", e -> {
  if (e.getSender() instanceof Player) {
    Player player = (Player) e.getSender();

    player.sendMessage("Hello Player!");
  }
});
```

Entity specific event listener, only events specific to this inventory will be triggered. This can be done to a class that implements `IEventListener`.
```java
AInventory inventory = new AInventoryBuilder().json(jsonData).build();

inventory.on(AInventoryClickEvent.class, e -> {
  e.setCancelled(true);
});
```

## Data
The data classes. (Note: The attributes must be public.)
```java
public class DatabaseContext extends Context {

	public ArrayList<Arena> arenas = new ArrayList<>();
	
}

public class Arena extends Data {

	public int id;
	public String name;
	public ArrayList<String> players = new ArrayList<>();
	
}
```

Register the context at startup and save it when the server closes.
```java
@Override
public void onEnable() {
  // This must only be done once.
  library.registerContext(DatabaseContext.class);
}

@Override
public void onDisable() {
  library.getContext(DatabaseContext.class).save(this);
}
```

Basic usage.
```java
DatabaseContext database = library.getContext(DatabaseContext.class);
database.arenas.add(new Arena() {{
  id = 1;
  name = "Arena name";
}});
```
