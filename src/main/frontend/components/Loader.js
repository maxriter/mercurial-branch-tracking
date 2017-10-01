import React, {PropTypes, Component} from "react";
import {RingLoader} from "react-spinners";

export default class Loader extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        if (this.props.loading) {
            return <div className="Loader">
                <RingLoader>
                    size={150}
                    color={'#f89406'}
                    loading={this.props.loading}
                </RingLoader>
            </div>
        }
        return null;
    }
}

Loader.propTypes = {
    loading: PropTypes.bool
};

