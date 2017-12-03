import {DATA_LOADED, DATA_FILTERED, BRANCH_SELECTED} from "../constants/Actions";

const initialState = {
    projects: [],
    allProjects: [],
    shownCommits: [],
    selectedBranch: {}
};

export default function projects(state = initialState, action) {
    switch (action.type) {
        case DATA_LOADED:
            return {...state, projects: action.payload, allProjects: action.payload, shownCommits: []};
        case DATA_FILTERED:
            return {...state, projects: action.payload, selectedBranch: {}, shownCommits: []};
        case BRANCH_SELECTED:
            let shownCommits = [];
            state.projects.forEach(project => {
                if (project.name === action.payload.projectName) {
                    project.openedBranches.forEach(branch => {
                        if (branch.name === action.payload.branchName) {
                            shownCommits = branch.commits;
                            return;
                        }
                    })
                }
            });
            return {...state, shownCommits: shownCommits, selectedBranch: action.payload};
        default:
            return state;
    }
}
