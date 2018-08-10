package source.kevtimov.starwarsapp.databaseFirestore;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.function.Consumer;

public class FirebaseRepository<T> implements Repository<T> {


    private final FirebaseFirestore mDb;
    private final Class<T> mKlass;
    private final String mCollectionName;


    public FirebaseRepository(Class<T> klass){
        mDb = FirebaseFirestore.getInstance();
        mKlass = klass;
        mCollectionName = mKlass.getSimpleName().toLowerCase() + "s";
    }





    @Override
    public void getAll(Consumer<List<T>> action) {
        mDb.collection(mCollectionName)
                .get()
                .addOnCompleteListener(task -> {
                    List<T> items = task.getResult()
                            .toObjects(mKlass);
                    action.accept(items);
                });
    }

    @Override
    public void add(T item, Consumer<T> action) {
        mDb.collection(mCollectionName)
                .add(item)
                .addOnCompleteListener(task -> action.accept(item));
    }
}
