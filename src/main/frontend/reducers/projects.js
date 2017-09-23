import {DATA_LOAD} from "../constants/Actions";

const initialState = {projects: []};

export default function projectsInfo(state = initialState, action) {
    switch (action.type) {
        case DATA_LOAD:
            return {...state, projects: action.payload};
        default:
            return {...state};
    }
}
