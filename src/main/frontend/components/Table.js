import React, {PropTypes, Component} from "react";

const DASH = " - ";

export default class Table extends Component {

    constructor(props) {
        super(props);
        this.props.loadData();
    }

    getBranch(openedBranch) {
        let relatedProjects = openedBranch.relatedProjects.length === 0 ? DASH : openedBranch.relatedProjects;
        let comment = openedBranch.comment ? openedBranch.comment : DASH;
        return <td>
            <ul>{"Name: " + openedBranch.name}</ul>
            <ul>{"Comment: " + comment}</ul>
            <ul>{"Related projects: " + relatedProjects}</ul>
        </td>;
    }

    renderAllProjectsInfo() {
        let rows = [];
        this.props.projects.forEach((project, i) => {
            project.openedBranches.forEach((branch, j) => {
                let key = project.name + j;
                let commitCell = i === 0 ?
                    <td rowSpan={this.getRowSpanForCommitCell()} className="Commit">Commits here...</td> : null;
                if (j === 0) {
                    rows.push(<tr key={key}>
                        <td rowSpan={project.openedBranches.length}>{project.name}</td>
                        {this.getBranch(branch)}
                        {commitCell}
                    </tr>);
                } else {
                    rows.push(<tr key={key}>
                        {this.getBranch(branch)}
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
    loadData: PropTypes.func.isRequired
};
