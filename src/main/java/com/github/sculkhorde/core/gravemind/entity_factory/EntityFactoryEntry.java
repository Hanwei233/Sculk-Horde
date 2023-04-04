package com.github.sculkhorde.core.gravemind.entity_factory;

import com.github.sculkhorde.core.gravemind.Gravemind;
import com.github.sculkhorde.core.SculkHorde;
import net.minecraft.entity.EntityType;

import javax.annotation.Nullable;

/**
 * This class is only used in the EntityFactory class which stores a list
 * of these entries. It is simply to store an EntityType and how much
 * sculk mass is required to spawn it.
 */
public class EntityFactoryEntry {

    private int orderCost = 0;
    private EntityType entity = null;
    private int limit = Integer.MAX_VALUE; // The limit of how many of this entity can be spawned
    public EntityFactory.StrategicValues strategicValue = EntityFactory.StrategicValues.Melee;
    public Gravemind.evolution_states minEvolutionRequired = Gravemind.evolution_states.Undeveloped;

    public EntityFactoryEntry(EntityType entity, int orderCost, EntityFactory.StrategicValues value, Gravemind.evolution_states minEvolution)
    {
        this.entity = entity;
        this.orderCost = orderCost;
        this.strategicValue = value;
        this.minEvolutionRequired = minEvolution;
    }

    // Getters and Setters

    /**
     * Sets the cost of spawning this entity
     * @return cost
     */
    public int getCost()
    {
        return orderCost;
    }

    /**
     * Sets the limit of how many of this entity can be spawned
     * @param limit The limit of how many of this entity can be spawned
     */
    public void setLimit(int limit)
    {
        this.limit = limit;
    }

    /**
     * Returns the limit of how many of this entity can be spawned
     * @return limit
     */
    public int getLimit()
    {
        return limit;
    }


    /**
     * Returns the entity type
     * @return entity
     */
    @Nullable
    public EntityType getEntity()
    {
        return entity;
    }

    /**
     * Returns the strategic value of this entity
     * @return strategicValue
     */
    public EntityFactory.StrategicValues getCategory()
    {
        return strategicValue;
    }

    public boolean isEntryAppropriate(ReinforcementRequest context)
    {
        if(context != null)
        {
            if((context.budget == -1 || context.budget >= orderCost)
                    && (context.approvedMobTypes.contains(strategicValue) || context.approvedMobTypes.isEmpty())
                    && SculkHorde.gravemind.isEvolutionStateEqualOrLessThanCurrent(minEvolutionRequired))
                return true;
        }
        else
            System.out.println("WARNING context is null");
        return false;
    }

}
