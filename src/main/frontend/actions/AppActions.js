import {dispatch} from "redux";
import {DATA_LOADED, LOADING_SET, DATA_FILTERED, BRANCH_SELECTED} from "../constants/Actions";
import {LOAD_INITIAL_DATA} from "../constants/URL";
import {NotificationManager} from "react-notifications";
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

export function clickOnBranch(data) {
    return {
        type: BRANCH_SELECTED,
        payload: data
    }
}

export function filterProjects(selectedProjects, projects) {
    // todo add filtering by branches after filtering by projects
    return function (dispatch) {
        if (selectedProjects.length == 0) {
            dispatch(receiveFilteredData(projects));
        } else {
            let filteredProjects = [];
            projects.forEach(project => {
                if (selectedProjects.indexOf(project.name) > -1) {
                    filteredProjects.push(project);
                }
            });
            dispatch(receiveFilteredData(filteredProjects));
        }
    }
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

export function receiveFilteredData(data) {
    return {
        type: DATA_FILTERED,
        payload: data
    }
}




