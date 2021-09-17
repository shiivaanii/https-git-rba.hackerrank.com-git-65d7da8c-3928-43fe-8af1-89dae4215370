package hackerrank;

import java.util.HashMap;
import java.util.stream.Collectors;

public class FurnitureOrder implements FurnitureOrderInterface {
	private final HashMap<Furniture, Integer> furniVar;
	
    FurnitureOrder() {
        // TODO: Complete the constructor
    	furniVar = new HashMap<Furniture, Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
    	{
            Integer count = 0;
            if(furniVar.containsKey(type)) {
                count = furniVar.get(type);
            }
            furniVar.put(type, count + furnitureCount);}
    	}

    public HashMap<Furniture, Integer> getOrderedFurniture() {
    	return new HashMap<Furniture, Integer>(furniVar);
    }

    public float getTotalOrderCost() {
        if(!furniVar.isEmpty()) {
        	return furniVar.entrySet().stream()
        			.map(f -> f.getKey().cost() * f.getValue())
        			.collect(Collectors.toList())
        			.stream()
        			.reduce(Float::sum)
        			.get();
        }
        return 0.0f;    }

    public int getTypeCount(Furniture type) {
    	if(furniVar.containsKey(type)) {
        	return furniVar.get(type);
        }
        return 0;
    }

    public float getTypeCost(Furniture type) {
    	if(furniVar.containsKey(type)) {
        	return furniVar.get(type) * type.cost();
        }
        return 0.0f;
    }

    public int getTotalOrderQuantity() {
    	if(!furniVar.isEmpty()) {
        	return furniVar.values().stream()
        			.reduce(Integer::sum)
        			.get();
        }
        return 0;
    }
}