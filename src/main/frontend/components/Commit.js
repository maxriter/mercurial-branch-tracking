import React, {Component, PropTypes} from "react";
import * as DateFormatter from "../util/DateFormatter";

export default class Commit extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return <div className="Commit">
            <ul>
                <span className="Commit-property">User: </span>
                {this.props.commit.user}
            </ul>
            <ul>
                <span className="Commit-property">Date: </span>
                {DateFormatter.parse(this.props.commit.date)}
            </ul>
            <ul>
                <span className="Commit-property">Message: </span>
                {this.props.commit.summary}
            </ul>
        </div>;
    }
}

Commit.propTypes = {
    commit: PropTypes.object.isRequired
};
