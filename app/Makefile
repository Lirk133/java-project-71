.DEFAULT_GOAL := build-run

setup:
	./gradlew wrapper --gradle-version 8.14

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/app/bin/app

test:
	./gradlew test

report:
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain

update-deps:
	./gradlew refreshVersions
	# ./gradlew dependencyUpdates -Drevision=release


build-run: build

.PHONY: build

test-d:
	./build/install/app/bin/app src/test/resources/file1.yml src/test/resources/file2.yml

test-plain:
	./build/install/app/bin/app --format plain src/test/resources/file1.yml src/test/resources/file2.yml

test-stylish:
	./build/install/app/bin/app --format stylish src/test/resources/file1.yml src/test/resources/file2.yml

test-json:
	./build/install/app/bin/app --format json src/test/resources/file1.yml src/test/resources/file2.yml

