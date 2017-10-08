import {dispatch} from "redux";
import {DATA_LOADED, LOADING_SET, DATA_FILTERED} from "../constants/Actions";
import {LOAD_INITIAL_DATA} from "../constants/URL";
import {NotificationContainer, NotificationManager} from "react-notifications";
import {DEFAULT_NOTIFICATION_TIMEOUT} from "../constants/Timeout";
import {PROJECTS} from "../constants/Mock";

export function loadData() {
    return function (dispatch) { 
        // dispatch(setLoading(true));
        // return fetch(LOAD_INITIAL_DATA)
        //     .then(response => response.json())
        //     .then(data => {
        //             if (data.projects) {
        //                 dispatch(receiveData(data.projects));
        //                 NotificationManager.success("Data was loaded successfully", "Success", DEFAULT_NOTIFICATION_TIMEOUT);
        //             } else {
        //                 NotificationManager.error("Ooops... error during retrieving data from server", "Error", DEFAULT_NOTIFICATION_TIMEOUT);
        //             }
        //             dispatch(setLoading(false));
        //         }
        //     )
        dispatch(receiveData(PROJECTS));

    };
}

export function filterByProjectName(projectName, projects) {
    return function (dispatch) {
        let filteredProjects = [];
        projects.forEach(project => {
            if(project.name == projectName){
                filteredProjects.push(project);
            }
        });
        dispatch(filterData(filteredProjects));
    }
}

export function filterByBranchName(branchName, projects) {

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

export function filterData(data) {
    return {
        type: DATA_FILTERED,
        payload: data
    }
}




