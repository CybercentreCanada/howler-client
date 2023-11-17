#!/usr/bin/env python
"""Howler Client Library PiP Installer"""

import os
from setuptools import setup, find_packages


def read(fname):
    try:
        with open(os.path.join(os.path.dirname(__file__), fname)) as fh:
            return fh.read()
    except IOError:
        return ""


def readVersion():
    with open("version.txt") as version:
        return "".join(version.read().splitlines())


long_description = read("../README.md")
requirements = read("requirements.txt").splitlines()

setup(
    name="howler-client",
    version=readVersion(),
    description="howler v1 client library",
    long_description=long_description,
    long_description_content_type="text/markdown",
    license="MIT",
    url="https://github.com/CybercentreCanada/howler-client",
    author="CSE-CST howler development team",
    author_email="howler@cyber.gc.ca",
    # See https://pypi.python.org/pypi?%3Aaction=list_classifiers
    classifiers=[
        "Development Status :: 5 - Production/Stable",
        "Intended Audience :: Developers",
        "Topic :: Software Development :: Libraries",
        "License :: OSI Approved :: MIT License",
        "Programming Language :: Python :: 3.9",
    ],
    install_requires=requirements,
    extras_require={"test": ["pytest", "pytest-cov", "cart", "passlib", "howler-api"]},
    keywords="development howler client gc canada cse-cst cse cst",
    packages=find_packages(exclude=["test/*"]),
)
