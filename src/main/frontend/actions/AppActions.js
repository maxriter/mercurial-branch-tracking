import * as Actions from "../constants/Actions";
import * as Mock from "../constants/Mock";

export function loadData() {
    return {
        type: Actions.DATA_LOAD,
        payload: Mock.PROJECTS
    }
}


