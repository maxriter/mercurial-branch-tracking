import React, {Component} from "react";
import {bindActionCreators} from "redux";
import {connect} from "react-redux";
import * as appActions from "../actions/AppActions";
import Table from "../components/Table";
import "react-notifications/lib/notifications.css";
import {NotificationContainer} from "react-notifications";
import Loader from "../components/Loader";

class App extends Component {

    render() {
        const {loadData} = this.props.appActions;
        const {projects, loading} = this.props;
        return <div className='row'>
            <NotificationContainer/>
            <Table projects={projects.projects} loadData={loadData}/>
            <Loader loading={loading.loading}/>
        </div>;
    }
}

function mapStateToProps(state) {
    return {
        projects: state.projects,
        loading: state.loading
    }
}

function mapDispatchToProps(dispatch) {
    return {
        appActions: bindActionCreators(appActions, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(App)