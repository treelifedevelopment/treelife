package me.Maiky1304.treelife.modules.vehicles.interfaces;
/*
Door: Maiky
Package: me.Maiky1304.treelife.modules.vehicles.interfaces in de class VehicleEntity.
*/

import me.Maiky1304.treelife.modules.vehicles.VehicleModule;
import org.bukkit.Material;
import org.bukkit.entity.ArmorStand;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class VehicleEntity {

    private ArmorStand as;

    public VehicleEntity(ArmorStand as){
        this.as = as;
    }

    public ItemStack getCarModel(){
        return as.getHelmet();
    }

    public String getVehicleID(){
        return as.getCustomName();
    }

    public boolean isCar(){
        if (getCarModel() != null && getCarModel().getType() == Material.DIAMOND_HOE){
            return true;
        }else{
            return false;
        }
    }

    public List<String> getOwners(){
        if (!isCar()){
            return null;
        }

        return VehicleModule.vehicles
                .getConfig().getStringList("vehicles." + getVehicleID() + ".owners");
    }

    public List<String> getMembers(){
        if (!isCar()){
            return null;
        }

        return VehicleModule.vehicles
                .getConfig().getStringList("vehicles." + getVehicleID() + ".members");
    }

    public void despawn(){
        as.remove();
    }

    public ArmorStand getEntity(){
        return as;
    }

}
