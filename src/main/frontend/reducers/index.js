import {combineReducers} from "redux";
import commits from "./commits";
import projects from "./projects";

export default combineReducers({
    commits,
    projects
})
