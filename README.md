# p6-process-model

P6 process engine model.

[![License](https://img.shields.io/github/license/p6-process/p6-process-model?style=for-the-badge&logo=apache)](https://www.apache.org/licenses/LICENSE-2.0)
[![GitHub Workflow Status (branch)](https://img.shields.io/github/workflow/status/p6-process/p6-process-model/build/master?logo=github&style=for-the-badge)](https://github.com/p6-process/p6-process-model/actions?query=workflow%3Abuild)
[![GitHub tag (latest SemVer)](https://img.shields.io/github/v/tag/p6-process/p6-process-model?logo=github&style=for-the-badge)](https://github.com/p6-process/p6-process-model/releases/latest)
[![Maven Central](https://img.shields.io/maven-central/v/org.lorislab.p6/p6-process-model?logo=java&style=for-the-badge)](https://maven-badges.herokuapp.com/maven-central/org.lorislab.p6/p6-process-model)

## P6 process definition

```yaml
id: parallelGateway
version: 1.0.0
labels:
  application: test
  module: module
metadata:
  ALL_PARAMETERS: true
nodes:
  start:
    type: START_EVENT
    next:
      - service1
  service1:
    type: SERVICE_TASK
    next:
      - gateway1
  gateway1:
    type: PARALLEL_GATEWAY
    sequence: DIVERGING
    next:
      - service3
      - service4
  service3:
    type: SERVICE_TASK
    next:
      - gateway2
  service4:
    type: SERVICE_TASK
    next:
      - gateway2
  gateway2:
    type: PARALLEL_GATEWAY
    sequence: CONVERGING
    next:
      - service5
  service5:
    type: SERVICE_TASK
    next:
      - end
  end:
    type: END_EVENT
```

### Create a release

```bash
mvn semver-release:release-create
```

### Create a patch branch
```bash
mvn semver-release:patch-create -DpatchVersion=x.x.0
```
