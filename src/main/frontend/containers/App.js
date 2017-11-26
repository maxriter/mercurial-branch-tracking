import React, {Component} from "react";
import {bindActionCreators} from "redux";
import {connect} from "react-redux";
import * as appActions from "../actions/AppActions";
import Table from "../components/Table";
import "react-notifications/lib/notifications.css";
import {NotificationContainer} from "react-notifications";
import Loader from "../components/Loader";
import Header from "../components/Header";

class App extends Component {
    render() {
        const {loadData, clickOnBranch} = this.props.appActions;
        const {filterProjects} = this.props.appActions;
        const {projects, loading} = this.props;
        return <div className='row'>
            <NotificationContainer/>
            <Header projects={projects.projects}
                    allProjects={projects.allProjects}
                    loadData={loadData}
                    filterProjects={filterProjects}/>
            <Table projects={projects.projects}
                   loadData={loadData}
                   clickOnBranch={clickOnBranch}
                   shownCommits={projects.shownCommits}/>
            <Loader loading={loading.loading}/>
        </div>;
    }
}

function mapStateToProps(state) {
    return {
        projects: state.projects,
        loading: state.loading,
        allProjects: state.allProjects,
        shownCommits: state.shownCommits
    }
}

function mapDispatchToProps(dispatch) {
    return {
        appActions: bindActionCreators(appActions, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(App)