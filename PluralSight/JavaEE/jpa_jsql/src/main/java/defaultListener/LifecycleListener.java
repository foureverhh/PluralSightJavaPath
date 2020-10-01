package defaultListener;

import org.eclipse.persistence.internal.expressions.OuterJoinExpressionHolder;

import javax.persistence.*;

public class LifecycleListener {
    @PrePersist
    void prePersist(Object object){
        System.out.println("PrePersist");
    }

    @PostPersist
    void postPersist(Object object){
        System.out.println("PostPersist");
    }

    @PreUpdate
    void preUpdate(Object o){
        System.out.println("PreUpdate");
    }

    @PostUpdate
    void postUpdate(Object o){
        System.out.println("PostUpdate");
    }

    @PreRemove
    void preRemove(Object o){
        System.out.println("PreRemove");
    }

    @PostRemove
    void postRemove(Object o){
        System.out.println("PostRemove");
    }

    @PostLoad
    void postLoad(Object o){
        System.out.println("PostLoad");
    }
}
