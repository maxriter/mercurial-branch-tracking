import {DATA_LOADED} from "../constants/Actions";

const initialState = {
    projects: []
};

export default function projects(state = initialState, action) {
    switch (action.type) {
        case DATA_LOADED:
            return {...state, projects: action.payload};
        default:
            return state;
    }
}
