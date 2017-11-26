import React, {Component, PropTypes} from "react";

export default class Branch extends Component {

    constructor(props) {
        super(props);
        this.handleBranchClick = this.handleBranchClick.bind(this);
    }

    handleBranchClick() {
        this.props.clickOnBranch({
            projectName: this.props.projectName,
            branchName: this.props.name
        });
    }

    render() {
        return <td className="Branch" onClick={this.handleBranchClick}>
            <ul>{"Name: " + this.props.name}</ul>
            <ul>{"Comment: " + this.props.comment}</ul>
            <ul>{"Related projects: " + this.props.relatedProjects}</ul>
        </td>
    }
}

Branch.propTypes = {
    projectName: PropTypes.string.isRequired,
    name: PropTypes.string.isRequired,
    comment: PropTypes.string.isRequired,
    relatedProjects: PropTypes.array.isRequired,
    clickOnBranch: PropTypes.func.isRequired
};
