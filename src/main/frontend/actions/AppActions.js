import {dispatch} from "redux";
import {DATA_LOADED, LOADING_SET} from "../constants/Actions";
import {LOAD_INITIAL_DATA} from "../constants/URL";
import {NotificationContainer, NotificationManager} from "react-notifications";
import {DEFAULT_NOTIFICATION_TIMEOUT} from "../constants/Timeout";

export function loadData() {
    return function (dispatch) {
        dispatch(setLoading(true));
        return fetch(LOAD_INITIAL_DATA)
            .then(response => response.json())
            .then(data => {
                    if (data.projects) {
                        dispatch(receiveData(data.projects));
                        NotificationManager.success("Data was loaded successfully", "Success", DEFAULT_NOTIFICATION_TIMEOUT);
                    } else {
                        NotificationManager.error("Ooops... error during retrieving data from server", "Error", DEFAULT_NOTIFICATION_TIMEOUT);
                    }
                    dispatch(setLoading(false));
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

export function setLoading(loading) {
    return {
        type: LOADING_SET,
        payload: loading
    }
}




