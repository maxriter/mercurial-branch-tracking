import {combineReducers} from "redux";
import loading from "./loading";
import projects from "./projects";

export default combineReducers({
    loading,
    projects
})
