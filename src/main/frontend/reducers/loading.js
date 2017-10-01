import {LOADING_SET} from "../constants/Actions";

const initialState = {
    loading: false
};

export default function loading(state = initialState, action) {
    switch (action.type) {
        case LOADING_SET:
            return {...state, loading: action.payload};
        default:
            return state;
    }
}