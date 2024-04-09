module.exports = {
    preset: 'ts-jest',
    testEnvironment: 'node',
    setupFilesAfterEnv: ['./test/setup.ts'], // You can set up any global test setup here
    moduleNameMapper: {
      '^src/(.*)$': '<rootDir>/src/$1',
    },
  };
