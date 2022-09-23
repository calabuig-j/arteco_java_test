package training.weather.interfaces;

import training.weather.model.ErrorModel;

public interface OnError {
    void run(ErrorModel error);
}
