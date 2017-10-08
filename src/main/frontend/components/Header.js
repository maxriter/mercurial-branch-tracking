import React, {PropTypes, Component} from "react";
import Select from 'react-select';

export default class Header extends Component {

    constructor(props) {
        super(props);
        this.handleSelectChange = this.handleSelectChange.bind(this);
        this.state = {
            selectedProjects: [],
            projectsOptions: []
        }
    }

    createProjectsOptions(projects) {
        let options = [];
        projects.forEach(project => {
            options.push({
                label: project.name,
                value: project.name
            });
        });
        return options;
    }

    handleSelectChange(value) {
        this.setState({
            selectedProjects: value
        });
    }

    render() {
        let options = this.createProjectsOptions(this.props.allProjects);
        let self = this;
        return (<div className="select_projects_section">
            <Select
                multi={true}
                backspaceRemoves={false}
                onChange={self.handleSelectChange}
                value={self.state.selectedProjects}
                options={options}
                simpleValue
                placeholder="Select project"
                backspaceRemoves={false}
            />
        </div>);
    }
}

Header.propTypes = {
    projects: PropTypes.array.isRequired,
    allProjects: PropTypes.array.isRequired,
    loadData: PropTypes.func.isRequired,
    filterData: PropTypes.func.isRequired
};
