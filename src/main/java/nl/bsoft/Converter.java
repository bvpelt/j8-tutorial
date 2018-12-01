package nl.bsoft;

@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}