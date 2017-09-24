import {DATA_LOADED, IS_LOADING_SET, ALERT_SHOW} from "../constants/Actions";

const initialState = {projects: [], isLoading: false};

export default function projectsInfo(state = initialState, action) {
    switch (action.type) {
        case DATA_LOADED:
            return {...state, projects: action.payload};
        case IS_LOADING_SET:
            return {...state, isLoading: action.payload};
        case ALERT_SHOW:
            // TODO add alerts from react-alert or another lib...
            // show alert with type and message while will be replaced by react-alert
            alert("Type of alert: " + action.payload.type + ", Message: " + action.payload.message);
            return {...state};
        default:
            return state;
    }
}
