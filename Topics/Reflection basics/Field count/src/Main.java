/**
 Get number of accessible public fields for a given class.
 */
class FieldGetter {

    public int getNumberOfAccessibleFields(Class<?> clazz) {
        clazz.getDeclaredMethods()
        return clazz.getFields().length;
    }

}