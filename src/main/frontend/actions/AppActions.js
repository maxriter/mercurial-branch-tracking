import {dispatch} from "redux";
import {DATA_LOADED, IS_LOADING_SET, ALERT_SHOW} from "../constants/Actions";
import {SUCCESS, ERROR} from "../constants/AlertType";
import {LOAD_INITIAL_DATA} from "../constants/URL";

export function loadData() {
    return function (dispatch) {
        dispatch(setIsLoading(true));
        return fetch(LOAD_INITIAL_DATA)
            .then(response => response.json())
            .then(data => {
                    if (data.projects) {
                        dispatch(receiveData(data.projects));
                        dispatch(showAlert(SUCCESS, "Data was loaded successfully"));
                    } else {
                        dispatch(showAlert(ERROR, "Ooops... error during retrieving data from server"));
                    }
                    dispatch(setIsLoading(false));
                }
            )
    };
}

export function receiveData(data) {
    return {
        type: DATA_LOADED,
        payload: data
    }
}

export function showAlert(type, message) {
    return {
        type: ALERT_SHOW,
        payload: {type: type, message: message}
    }
}

export function setIsLoading(isLoading) {
    return {
        type: IS_LOADING_SET,
        payload: isLoading
    }
}




