import React, {PropTypes, Component} from "react";
import Commit from "./Commit";
import Branch from "./Branch";

const DASH = " - ";

export default class Table extends Component {

    constructor(props) {
        super(props);
        this.props.loadData();
    }

    getBranch(openedBranch, projectName) {
        let relatedProjects = openedBranch.relatedProjects.length === 0 ? DASH : openedBranch.relatedProjects;
        let comment = openedBranch.comment ? openedBranch.comment : DASH;
        return <Branch projectName={projectName}
                       name={openedBranch.name}
                       comment={comment}
                       relatedProjects={relatedProjects}
                       clickOnBranch={this.props.clickOnBranch}/>
    }

    getShownCommits() {
        return this.props.shownCommits.map(commit => <Commit commit={commit}/>);
    }

    renderAllProjectsInfo() {
        let rows = [];
        this.props.projects.forEach((project, i) => {
            project.openedBranches.forEach((branch, j) => {
                let key = project.name + j;
                let commitCell = i === 0 ?
                    <td rowSpan={this.getRowSpanForCommitCell()}>
                        {this.getShownCommits()}
                    </td> : null;
                if (j === 0) {
                    rows.push(<tr key={key}>
                        <td rowSpan={project.openedBranches.length}>{project.name}</td>
                        {this.getBranch(branch, project.name)}
                        {commitCell}
                    </tr>);
                } else {
                    rows.push(<tr key={key}>
                        {this.getBranch(branch, project.name)}
                    </tr>);
                }
            });
        });
        return rows;
    }

    getRowSpanForCommitCell() {
        // rowSpan for commit cell equals opened branches count of all projects
        return this.props.projects.reduce((count, project) => {
            return count + project.openedBranches.length;
        }, 0);
    }

    render() {
        if (this.props.projects.length) {
            return <table>
                <tbody>
                <tr>
                    <th>Project</th>
                    <th>Branches</th>
                    <th>Commits</th>
                </tr>
                {this.renderAllProjectsInfo()}
                </tbody>
            </table>;
        }
        return null;
    }
}

Table.propTypes = {
    projects: PropTypes.array.isRequired,
    shownCommits: PropTypes.array.isRequired,
    loadData: PropTypes.func.isRequired,
    clickOnBranch: PropTypes.func.isRequired
};
