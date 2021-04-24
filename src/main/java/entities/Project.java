package entities;

import java.lang.reflect.Array;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *  La clase Proyect representa a un proyecto de la universidad
 */
public class Project {

    private String name;
    private LocalDate dateInit;
    private LocalDate dateEnd;
    private Group group;
    private List<Iteration> iterations;

    public Project(String name, LocalDate dateInit, LocalDate dateEnd, Group group) {
        this.name = name;
        this.dateInit = dateInit;
        this.dateEnd = dateEnd;
        this.group = group;
        this.iterations = new ArrayList<>();

        group.addProject(this);
    }

    public void addIteration(Iteration iteration) {
        this.iterations.add(iteration);
    }

    /**
     * Obtiene la duración del proyecto
     * @return la duracion en dias del proyecto
     * @throws SabanaResearchException
     */
    public Duration getDuration() throws SabanaResearchException {

        Duration d = Duration.ofDays(0);
        if(iterations.size() == 0)
        {
            throw new SabanaResearchException(SabanaResearchException.BAD_FORMED_PROJECT);
        }
        for(Iteration e:this.iterations)
        {
            Duration a = e.getDuration();
            d = d.plus(a);
        }
        return d;
    }





}
