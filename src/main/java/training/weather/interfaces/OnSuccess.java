package training.weather.interfaces;

public interface OnSuccess<T> {
    void run(T model);
}
