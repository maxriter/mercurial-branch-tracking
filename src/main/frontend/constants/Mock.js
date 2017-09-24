// TODD currently isn't used, should be removed later
export const PROJECTS = [{
    name: "sqc-account-overview",
    openedBranches: [
        {
            name: "AOCMW1",
            comment: "This is AOCMW1 branch from [sqc-account-overview]",
            relatedProjects: ["sqc-settings-plugin", "sqc-messages-plugin"],
            commits: []
        },
        {
            name: "AOCMW2",
            comment: "This is AOCMW2 branch from [sqc-account-overview] ",
            relatedProjects: [],
            commits: []
        }
    ]
},
    {
        name: "sqc-messages-plugin",
        openedBranches: [
            {
                name: "AOCMW1",
                comment: "This is AOCMW1 branch from [sqc-messages-plugin] ",
                relatedProjects: ["sqc-account-overview", "sqc-settings-plugin"],
                commits: []
            },
            {
                name: "AOCMW3",
                comment: "This is AOCMW3 branch from [sqc-messages-plugin]",
                relatedProjects: ["sqc-settings-plugin"],
                commits: []
            }
        ]
    },
    {
        name: "sqc-settings-plugin",
        openedBranches: [
            {
                name: "AOCMW1",
                comment: "This is AOCMW1 branch from [sqc-settings-plugin] ",
                relatedProjects: ["sqc-account-overview", "sqc-messages-plugin"],
                commits: []
            },
            {
                name: "AOCMW3",
                comment: "This is AOCMW3 branch from [sqc-settings-plugin]",
                relatedProjects: ["sqc-messages-plugin"],
                commits: []
            },
            {
                name: "AOCMW6",
                comment: "This is AOCMW6 branch from [sqc-settings-plugin]",
                relatedProjects: [],
                commits: []
            },
            {
                name: "AOCMW7",
                comment: "This is AOCMW7 branch from [sqc-settings-plugin]",
                relatedProjects: [],
                commits: []
            }
        ]
    }
];