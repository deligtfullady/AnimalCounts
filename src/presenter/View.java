package presenter;

import org.example.models.Animal;

import java.util.Collection;

public interface View {
    void showAnimals(Collection<Animal> var1);
    void setObserver(ViewObserver var1);

}
