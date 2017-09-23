import React, {Component} from "react";
import {bindActionCreators} from "redux";
import {connect} from "react-redux";
import * as appActions from "../actions/AppActions";
import Table from "../components/Table";

class App extends Component {
    render() {
        const {loadData} = this.props.appActions;
        return <div className='row'>
            <Table projects={this.props.projects.projects} loadData={loadData}/>
        </div>
    }
}

function mapStateToProps(state) {
    return {
        projects: state.projects
    }
}

function mapDispatchToProps(dispatch) {
    return {
        appActions: bindActionCreators(appActions, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(App)