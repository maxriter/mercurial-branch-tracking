import {DATA_LOADED, DATA_FILTERED} from "../constants/Actions";

const initialState = {
    projects: [],
    allProjects: []
};

export default function projects(state = initialState, action) {
    switch (action.type) {
        case DATA_LOADED:
            return {...state, projects: action.payload, allProjects: action.payload};
        case DATA_FILTERED:
            return {...state, projects: action.payload};
        default:
            return state;
    }
}
