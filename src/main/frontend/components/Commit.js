import React, {Component, PropTypes} from "react";
import * as DateFormatter from "../util/DateFormatter";

export default class Commit extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return <div className="Commit">
            <div>Changeset: {this.props.commit.changeset}</div>
            <div>Branch: {this.props.commit.branch}</div>
            <div>User: {this.props.commit.user}</div>
            <div>Date: {DateFormatter.parse(this.props.commit.date)}</div>
            <div>Message: {this.props.commit.summary}</div>
        </div>;
    }
}

Commit.propTypes = {
    commit: PropTypes.object.isRequired
};
